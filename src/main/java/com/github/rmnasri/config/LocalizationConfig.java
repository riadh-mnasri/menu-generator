package com.github.rmnasri.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;

/**
 * Created by riadh on 10/05/15.
 */
@Configuration
public class LocalizationConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(LocalizationConfig.class);

    private static final String BUNDLE_ENCODING = "UTF-8";

    private static final int CACHE_RETENTION = 10;

    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        String[] fileNames = {"classpath:/localization/messages"};
        messageSource.setBasenames(fileNames);
        messageSource.setCacheSeconds(CACHE_RETENTION);
        messageSource.setDefaultEncoding(BUNDLE_ENCODING);
        LOGGER.trace("Loading message bundles {}", Arrays.toString(fileNames));
        return messageSource;
    }

}
