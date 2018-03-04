package py.com.api.demo.sys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;

import py.com.api.demo.rest.ApiPaths;

/**
 * API Configuration
 *
 * @author felipehermosilla
 */
@Configuration
@EnableSwagger
public class SwaggerConfig {

	private SpringSwaggerConfig config;

	@Autowired
	public void setConfig(SpringSwaggerConfig config) {
		this.config = config;
	}

	@Bean
	public SwaggerSpringMvcPlugin getSwagger() {
		return new SwaggerSpringMvcPlugin(this.config).apiInfo(apiInfo()).useDefaultResponseMessages(false)
				.includePatterns(ApiPaths.API_PATTERN);
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("API-DEMO API", "REST-API examples", "Terms of Service", "feliphermosilla@gmail.com",
				"Felipe Hermosilla", "cloud");
	}

}

