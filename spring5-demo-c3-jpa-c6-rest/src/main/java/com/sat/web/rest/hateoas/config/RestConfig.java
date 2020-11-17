package com.sat.web.rest.hateoas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.hateoas.server.RepresentationModelProcessor;

import com.sat.bean.Taco;

@Configuration
public class RestConfig {
	
	@Bean
	public RepresentationModelProcessor<PagedModel<EntityModel<Taco>>> tacoProcessor(EntityLinks links){
		return new RepresentationModelProcessor<PagedModel<EntityModel<Taco>>> () {

			@Override
			public PagedModel<EntityModel<Taco>> process(PagedModel<EntityModel<Taco>> model) {
				// TODO Auto-generated method stub
				model.add(
					links.linkFor(Taco.class)
						 .slash("recent")
						 .withRel("recents"));
				return model;
			}
			
		};
	}
}
