/*******************************************************************************
 * Copyright (C) 2020 Gyaltso Technologies (https://gyaltso.com/)
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package com.gyaltso.lcp.ladu.project.project

class PomFile {

	def static getContent(String groupId, String artifactId, String version) '''
		<project xmlns="http://maven.apache.org/POM/4.0.0"
			xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
			xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
			<modelVersion>4.0.0</modelVersion>
		
			<parent>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-starter-parent</artifactId>
				<version>2.3.4.RELEASE</version>
				<relativePath />
			</parent>
		
			<groupId>«groupId»</groupId>
			<artifactId>«artifactId»</artifactId>
			<version>«version»</version>
		
			<properties>
				<java.version>11</java.version>
			</properties>
		
			<dependencies>
				<dependency>
					<groupId>org.springframework.boot</groupId>
					<artifactId>spring-boot-devtools</artifactId>
					<scope>runtime</scope>
					<optional>true</optional>
				</dependency>
				<dependency>
					<groupId>org.springframework.boot</groupId>
					<artifactId>spring-boot-starter-web</artifactId>
				</dependency>
				<dependency>
					<groupId>org.springframework.boot</groupId>
					<artifactId>spring-boot-starter-test</artifactId>
					<scope>test</scope>
					<exclusions>
						<exclusion>
							<groupId>org.junit.vintage</groupId>
							<artifactId>junit-vintage-engine</artifactId>
						</exclusion>
					</exclusions>
				</dependency>
				<dependency>
					<groupId>org.eclipse.xtext</groupId>
					<artifactId>org.eclipse.xtext</artifactId>
					<version>2.23.0</version>
				</dependency>
				<dependency>
					<groupId>org.eclipse.xtext</groupId>
					<artifactId>org.eclipse.xtext.xbase</artifactId>
					<version>2.23.0</version>
				</dependency>
				<dependency>
					<groupId>org.springframework.boot</groupId>
					<artifactId>spring-boot-starter-data-jpa</artifactId>
				</dependency>
				<dependency>
					<groupId>com.h2database</groupId>
					<artifactId>h2</artifactId>
					<scope>runtime</scope>
				</dependency>
			</dependencies>
		
			<build>
				<sourceDirectory>src-gen</sourceDirectory>
				<plugins>
					<plugin>
						<groupId>org.springframework.boot</groupId>
						<artifactId>spring-boot-maven-plugin</artifactId>
					</plugin>
				</plugins>
			</build>
		
		</project>
	'''

}
