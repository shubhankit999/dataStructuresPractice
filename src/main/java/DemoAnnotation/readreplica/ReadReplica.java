package DemoAnnotation.readreplica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.env.Environment;
import org.springframework.core.env.SimpleCommandLinePropertySource;

import javax.annotation.PostConstruct;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.TimeZone;

@SpringBootApplication
@EnableAutoConfiguration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan({})
public class ReadReplica extends SpringBootServletInitializer {

    @PostConstruct
    void setTimezoneToUTC() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }

    public static void main(String[] args) {
        SpringApplication.run(ReadReplica.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ReadReplica.class);
    }

    @ReadFromReplica
    public static void getData() {
        System.out.println("njdvs");
    }
}
