package com.portflow.infra.beans;

import com.portflow.core.gateway.ContainerGateway;
import com.portflow.core.usecases.allocation.*;
import com.portflow.core.usecases.container.*;
import com.portflow.core.usecases.yardslot.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfiguration {

    @Bean
    public CheckInContainerUsecase checkInContainerUsecase(){
        return new CheckInContainerUsecaseImpl();
    }

    @Bean
    public CheckOutContainerUsecase checkOutContainerUsecase(){
        return new CheckOutContainerUsecaseImpl();
    }

    @Bean
    public GetContainerHistoryUsecase getContainerHistoryUsecase(){
        return new GetContainerHistoryUsecaseImpl();
    }

    @Bean
    public RelocateContainerUsecase relocateContainerUsecase(){
        return new RelocateContainerUsecaseImpl();
    }

    @Bean
    public GetContainerByCodeUsecase getContainerByCodeUsecase(ContainerGateway containerGateway){
        return new GetContainerByCodeUsecaseImpl(containerGateway);
    }

    @Bean
    public ListAllContainersUsecase listAllContainersUsecase(ContainerGateway containerGateway){
        return new ListAllContainersUsecaseImpl(containerGateway);
    }

    @Bean
    public RegisterContainerUsecase registerContainerUsecase(ContainerGateway containerGateway){
        return new RegisterContainerUsecaseImpl(containerGateway);
    }

    @Bean
    public UpdateContainerUsecase updateContainerUsecase(ContainerGateway containerGateway){
        return new UpdateContainerUsecaseImpl(containerGateway);
    }

    @Bean
    public FindAvailableSlotUsecase findAvailableSlotUsecase(){
        return new FindAvailableSlotUsecaseImpl();
    }

    @Bean
    public GetYardStructureUsecase getYardStructureUsecase(){
        return new GetYardStructureUsecaseImpl();
    }

    @Bean
    public InitializeYardBlockUsecase initializeYardBlockUsecase(){
        return new InitializeYardBlockUsecaseImpl();
    }

    @Bean
    public SetSlotMaintenanceStatusUsecase setSlotMaintenanceStatusUsecase(){
        return new SetSlotMaintenanceStatusUsecaseImpl();
    }

}
