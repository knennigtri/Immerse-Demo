package com.nennig.immerse.core;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

@Component
@Service(MyService.class)
public class MyServiceImpl implements MyService{

	@Override
	public String myMethod() {
		return "Hello I'm using my custom service implementation!";
	}
}
