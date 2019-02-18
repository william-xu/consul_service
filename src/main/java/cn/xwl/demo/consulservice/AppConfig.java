package cn.xwl.demo.consulservice;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
public class AppConfig {

	private String springDatasourceUrl = "";
	private String signingKey;

	public String getSpringDatasourceUrl() {
		return springDatasourceUrl;
	}

	public void setSpringDatasourceUrl(String springDatasourceUrl) {
		this.springDatasourceUrl = springDatasourceUrl;
	}

	public String getSigningKey() {
		return signingKey;
	}

	public void setSigningKey(String signingKey) {
		this.signingKey = signingKey;
	}

}
