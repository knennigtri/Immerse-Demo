package com.nennig.immerse.core;

import javax.jcr.Session;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.PropertyUnbounded;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.hc.api.HealthCheck;
import org.apache.sling.hc.api.Result;
import org.apache.sling.jcr.api.SlingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(metatype=true, label="Immerse Health Check",
        description="This is a Simple Health Check.")
@Properties({
        @Property(name=HealthCheck.NAME, value="Immerse Health Check"),
        @Property(name=HealthCheck.TAGS, unbounded= PropertyUnbounded.ARRAY, value={"security", "test"},
                label="Tags", description="Tags for the health check."),
        @Property(name=HealthCheck.MBEAN_NAME, value="immerseHealthCheck",
                label="MBean Name", description="Name of the JMX mbean to register for this check.")
})
@Service(value=HealthCheck.class)
public class ImmerseHealthCheck implements HealthCheck {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	private static String jcrPath= "/content/immerse/en/health-check";
	
	@Reference
	private SlingRepository repository;
	
	@Override
	public Result execute() {
		logger.info("Immerse healthcheck is running");
		try {
			Session session = repository.loginService("immerse", null);
			if(session.itemExists(jcrPath)){
				return new Result(Result.Status.OK, jcrPath + " exists");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(Result.Status.CRITICAL, "Cannot access the JCR to perform Health Check");
		}
		return new Result(Result.Status.WARN, jcrPath + " does not exist.");
	}

}