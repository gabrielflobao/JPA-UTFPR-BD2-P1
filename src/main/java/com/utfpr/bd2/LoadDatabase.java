package com.utfpr.bd2;

import com.utfpr.bd2.entity.Dirige;
import com.utfpr.bd2.entity.Motorista;
import com.utfpr.bd2.entity.Veiculo;
import com.utfpr.bd2.service.DirigeService;
import com.utfpr.bd2.service.MotoristaService;
import com.utfpr.bd2.service.VeiculoService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

@Component
public class LoadDatabase implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    private final DirigeService dirigeService;
    private final MotoristaService motoristaService;
    private final VeiculoService veiculoService;

    public LoadDatabase(DirigeService dirigeService, MotoristaService motoristaService, VeiculoService veiculoService) {
        this.dirigeService = dirigeService;
        this.motoristaService = motoristaService;
        this.veiculoService = veiculoService;

    }


    @Override
    public void run(String... args) throws Exception {
    try {
        log.info("STARTING SOMETHINGS TO DO....");
        log.info("Inserting 3 motoristas...");
        Motorista motorista = new Motorista();
        motorista.setNome("Gabriel");
        motorista.setSexo("Masculino");
        motorista.setTelefone("21994188658");
        Motorista m2 = new Motorista();
        m2.setNome("Luiz");
        m2.setSexo("Masculino");
        m2.setTelefone("2199745973");
        Motorista m3 = new Motorista();
        m3.setNome("Felipe");
        m3.setSexo("Masculino");
        m3.setTelefone("2194589348");
        motoristaService.salvar(motorista);
        motoristaService.salvar(m2);
        motoristaService.salvar(m3);
        log.info("Inserting 3 veiculos...");
        Veiculo v1 = new Veiculo();
        Veiculo v2 = new Veiculo();
        Veiculo v3 = new Veiculo();
        v1.setMarca("Toyota");
        v1.setModelo("Yaris");
        v2.setModelo("Gol");
        v2.setMarca("Volkswagen");
        v3.setMarca("Ford");
        v3.setModelo("Mustagen");
        veiculoService.salvar(v1);
        veiculoService.salvar(v2);
        veiculoService.salvar(v3);
        log.info("List motoristas : ");
        motoristaService.listar().forEach(motorista1 -> System.out.println(motorista1.toString()));
        log.info("List veiculos :"+veiculoService.listar().toString());
        veiculoService.listar().forEach(veiculo1 -> System.out.println(veiculo1.toString()));
        log.info("Inserting three dirige... ");
        dirigeService.salvar(new Dirige(motorista,v1));
        dirigeService.salvar(new Dirige(m2,v2));
        dirigeService.salvar(new Dirige(m3,v3));
        dirigeService.salvar(new Dirige(LocalDate.of(2023, Month.APRIL,20),Time.valueOf(LocalTime.now()),m3,v3));
        log.info("Deleting motorista id 1");
        motoristaService.deleteById(1L);
        log.info("List motoristas : ");
        motoristaService.listar().forEach(motorista1 -> System.out.println(motorista1.toString()));
        log.info("Deleting veiculo id 1");
        veiculoService.deleteById(1L);
        log.info("List all dirige by period");
        dirigeService.findByPeriod(LocalDate.of(2023, Month.APRIL,  19),LocalDate.now()).forEach(dirige -> System.out.println(dirige.toString()));
        log.info("List veiculo : ");
        motoristaService.listar().forEach(motorista1 -> System.out.println(motorista1.toString()));
        log.info("List motoristas order by asc : ");
        motoristaService.listar().forEach(motorista1 -> System.out.println(motorista1.toString()));
        log.info("Couting all veiculos : ");
        System.out.println(veiculoService.countEntity());


    }catch (Exception e ) {
        log.info(e.getMessage());
        e.printStackTrace();
        }
    }

}
