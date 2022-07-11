package com.spring.actuator.api.endpoint;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "actuatorDemo", enableByDefault = true)
public class MyEndpoint {

    @ReadOperation
    public MyEndPointResponse features() {
        return new MyEndPointResponse(143, "test", "Active");
    }
}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class MyEndPointResponse {
    private int Id;
    private String name;
    private String status;
}
