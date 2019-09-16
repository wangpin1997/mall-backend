package cn.wpin.mall.backend.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Feign;
import feign.Request;
import feign.codec.Decoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

/**
 * feign 访问以及负载均衡
 * @author wangpin
 */
@Configuration
public class FeignConfiguration {


    @Bean
    public Feign.Builder feignBuilder(@Autowired Decoder decoder , @Qualifier("feignRequestOptions") Request.Options options) {
        Feign.Builder builder = Feign.builder();
        builder.decoder(decoder);
        builder.options(options);
        return builder;
    }


    @Bean(name = "feignRequestOptions")
    Request.Options requestOptions(ConfigurableEnvironment env){
        int ribbonReadTimeout = env.getProperty("ribbon.ReadTimeout", int.class, 6000);
        int ribbonConnectionTimeout = env.getProperty("ribbon.ConnectTimeout", int.class, 3000);

        return new Request.Options(ribbonConnectionTimeout, ribbonReadTimeout);
    }


    @Bean
    public Decoder feignDecoder(@Autowired ObjectMapper objectMapper) {
        HttpMessageConverter jacksonConverter = new MappingJackson2HttpMessageConverter(objectMapper);
        ObjectFactory<HttpMessageConverters> objectFactory = () -> new HttpMessageConverters(jacksonConverter);
        return new ResponseEntityDecoder(new SpringDecoder(objectFactory));
    }

}