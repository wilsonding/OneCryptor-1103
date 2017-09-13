package com.dosurely.onecryptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;

@Configuration
public class TilesConfiguration {

	/**
	 * Tiles Configuration
	 * @return
	 */
	@Bean
	public TilesConfigurer tilesConfigurer() {
		final TilesConfigurer configurer = new TilesConfigurer();
		configurer.setDefinitions(new String[] {"WEB-INF/tiles/tiles.xml"});
		configurer.setCheckRefresh(true);
		return configurer;
	}
	
	/**
	 * Introduce a Tiles view resolver, this is a convenience implementation that extends URLBaseViewResolver.
	 */
	@Bean
	public TilesViewResolver tilesViewResolver() {
		final TilesViewResolver resolver = new TilesViewResolver();
		resolver.setViewClass(TilesView.class);
		return resolver;
	}
}
