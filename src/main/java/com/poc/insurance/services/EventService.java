package com.poc.insurance.services;

import com.poc.insurance.models.*;
import com.poc.insurance.repositorys.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

import static com.poc.insurance.models.PocType.NOTIFICATION;

@Component
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private FinancialService financialService;

    public Event sendEventToBroker(Event newEvent){
        Client client = new Client("43a96b5e-e291-11ec-8fea-0242ac120002", "Cleiton", "asdsa");
        Contract contrato = new Contract("ff35fd7c-e2ac-11ec-8fea-0242ac120002", 40_000.00, 60_000.00);
        financialService.persistClientandContract(contrato, client);
        Data data  = new Data(NOTIFICATION, client, contrato);
        HashMap<String, Object> mapData = new HashMap<>();
        mapData.put("PocType", data.getPocType());
        mapData.put("Cliente", data.getCliente().getIdCliente());
        mapData.put("Contrato", data.getContrato().getIdContrato());
        newEvent.setData(mapData);
        return newEvent;
    }


    public List<Event> getEvents(){
        List<Event> events = eventRepository.findAll();
        return events;
    }

    public Financial returnContractAndClient(String idCliente, String idContrato){
        List<Financial> financials = financialService.getFinancials();
        for(Financial financial : financials){
            if(financial.getClient().getIdCliente().equals(idCliente) &&
            financial.getContract().getIdContrato().equals(idContrato)){
                return financial;
            }
        }
        return null;
    }


}
