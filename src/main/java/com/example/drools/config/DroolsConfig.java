package com.example.drools.config;

import java.io.File;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.runtime.KieContainer;
import org.kie.internal.io.ResourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DroolsConfig {

	private static final String drl_file_path = "src/main/resources/rules";

	private static final KieServices kieServices = KieServices.Factory.get();

	@Bean
	KieContainer kieContainer() {
		KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
		File dir = new File(drl_file_path);
		File[] directoryListing = dir.listFiles();
		if (directoryListing != null) {
			for (File child : directoryListing) {
				kieFileSystem.write(ResourceFactory.newFileResource(child));
			}
		}
		KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem);
		kieBuilder.buildAll();
		KieModule kieModule = kieBuilder.getKieModule();
		KieContainer kieContainer = kieServices.newKieContainer(kieModule.getReleaseId());
		return kieContainer;
	}
}
