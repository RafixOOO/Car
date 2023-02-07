package com.example.car;

import com.example.car.model1.CarEquipment;
import com.example.car.models.*;
import com.example.car.repo.*;
import com.example.car.repo1.CarEquipmentRepository;
import com.example.car.repo1.CarOptionRepository;
import com.example.car.repo1.CarOptionValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.*;

@Controller
public class AppController {

    @Autowired
    public CarEquipmentRepository carEquipmentRepository;

    @Autowired
    public CarGenerationRepository carGenerationRepository;

    @Autowired
    public CarMakeRepository carMakeRepository;

    @Autowired
    public CarModelRepository carModelRepository;

    @Autowired
    public CarOptionRepository carOptionRepository;

    @Autowired
    public CarOptionValueRepository carOptionValueRepository;

    @Autowired
    public CarSerieRepository carSerieRepository;

    @Autowired
    public CarSpecificationRepository carSpecificationRepository;

    @Autowired
    public  CarSpecificationValueRepository carSpecificationValueRepository;

    @Autowired
    public CarTrimRepository carTrimRepository;

    @Autowired
    public CarTypeRepository carTypeRepository;

    @Autowired
    private JdbcTemplate jdbcTemplateTwo;

    @Autowired
    private JdbcTemplate jdbcTemplateOne;

    String Make = "";
    String Model = "";
    String Generation = "";
    String Series = "";
    String Trim = "";
    String Equipment = "";

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("car", carMakeRepository.findAll());
        FormCommand formCommand = new FormCommand();
        model.addAttribute("command", formCommand);
        return "Index";
    }

    @RequestMapping(value ="/car", method = RequestMethod.GET)
    public String car(Model model, FormCommand command){

        Make = command.getTextField();

        CarMake car = carMakeRepository.findByName(Make);
        model.addAttribute("model", carModelRepository.findByIdCarMake(car.getId()));

        FormCommand formCommand = new FormCommand();
        model.addAttribute("command", formCommand);

        return "Model";
    }

    @RequestMapping(value ="/car1", method = RequestMethod.GET)
    public String car1(Model model, FormCommand command){

        Model = command.getTextareaField();

        CarModel car = carModelRepository.findByName(Model);
        model.addAttribute("Generation", carGenerationRepository.findByIdCarModel(car.getId()));

        FormCommand formCommand = new FormCommand();
        model.addAttribute("command", formCommand);

        return "Generation";
    }

    @RequestMapping(value ="/car2", method = RequestMethod.GET)
    public String car2(Model model, FormCommand command){

        Generation = command.getTextareaField();

        CarModel car1 = carModelRepository.findByName(Model);

        CarGeneration car = carGenerationRepository.findByIdCarModelAndName(car1.getId(), Generation);
        model.addAttribute("Serie", carSerieRepository.findByIdCarModelAndIdCarGeneration(car1.getId(), car.getId()));

        FormCommand formCommand = new FormCommand();
        model.addAttribute("command", formCommand);

        return "Serie";
    }

    @RequestMapping(value ="/car3", method = RequestMethod.GET)
    public String car3(Model model, FormCommand command){

        Series = command.getTextareaField();

        CarModel car1 = carModelRepository.findByName(Model);
        CarGeneration car2 = carGenerationRepository.findByIdCarModelAndName(car1.getId(), Generation);
        CarSerie car = carSerieRepository.findByNameAndIdCarModelAndIdCarGeneration(Series, car1.getId(), car2.getId() );

        model.addAttribute("Trim", carTrimRepository.findByIdCarSerieAndIdCarModel(car.getId(), car1.getId()));

        FormCommand formCommand = new FormCommand();
        model.addAttribute("command", formCommand);

        return "Trim";
    }

    @RequestMapping(value ="/car4", method = RequestMethod.GET)
    public String car4(Model model, FormCommand command){

        Trim = command.getTextareaField();

        CarModel car1 = carModelRepository.findByName(Model);
        CarGeneration car2 = carGenerationRepository.findByIdCarModelAndName(car1.getId(), Generation);
        CarSerie car = carSerieRepository.findByNameAndIdCarModelAndIdCarGeneration(Series, car1.getId(), car2.getId() );
        CarTrim car3 = carTrimRepository.findByNameAndIdCarSerieAndIdCarModel(Trim, car.getId(), car1.getId());
        model.addAttribute("Equ", jdbcTemplateTwo.queryForList("SELECT * FROM `car_equipment` WHERE `id_car_trim`= "+car3.getId()));

        FormCommand formCommand = new FormCommand();
        model.addAttribute("command", formCommand);

        return "Equ";
    }

    @RequestMapping(value="/car5")
    public String all(Model model, FormCommand command){

        Equipment=command.getTextareaField();

        model.addAttribute("make", Make);
        model.addAttribute("model", Model);
        model.addAttribute("generation", Generation);
        model.addAttribute("series", Series);
        model.addAttribute("trim", Trim);
        model.addAttribute("equ", Equipment);

        CarModel car1 = carModelRepository.findByName(Model);
        CarGeneration car2 = carGenerationRepository.findByIdCarModelAndName(car1.getId(), Generation);
        CarSerie car = carSerieRepository.findByNameAndIdCarModelAndIdCarGeneration(Series, car1.getId(), car2.getId() );

        CarTrim car3 = carTrimRepository.findByNameAndIdCarSerieAndIdCarModel(Trim, car.getId(), car1.getId());
        CarEquipment car4=jdbcTemplateTwo.queryForObject("SELECT * FROM car_equipment WHERE id_car_trim="+car3.getId()+" AND name='"+Equipment+"' Limit 1", new BeanPropertyRowMapper<CarEquipment>(CarEquipment.class));

        model.addAttribute("spec",jdbcTemplateOne.queryForList("SELECT car_specification.name, car_specification_value.value, car_specification_value.unit FROM car_specification, car_specification_value WHERE car_specification.id_car_specification=car_specification_value.id_car_specification and id_car_trim="+car3.getId()));
        model.addAttribute("opti",jdbcTemplateTwo.queryForList("SELECT car_option.name FROM car_equipment, car_option_value, car_option WHERE car_equipment.id_car_equipment=car_option_value.id_car_equipment AND car_option_value.id_car_option=car_option.id_car_option and car_equipment.id_car_equipment=(SELECT car_equipment.id_car_equipment FROM car_equipment WHERE id_car_trim="+car3.getId()+" AND name='Elite' LIMIT 1)"));

        return "All";
    }

    @RequestMapping("/graphfuel")
    public String barGraph(Model model) {
        List<Map<String,Object>> survey = jdbcTemplateOne.queryForList("SELECT SUM(car_specification_value.value) AS Suma FROM car_specification_value, car_specification WHERE car_specification_value.id_car_specification=car_specification.id_car_specification AND car_specification.name='FUEL' GROUP BY car_specification_value.value");
        Map<String, Integer> surveyMap = new LinkedHashMap<>();
        int all = 1341;
        surveyMap.put("80 RON", 9);
        surveyMap.put("92 RON", 274);
        surveyMap.put("95 RON", 1033);
        surveyMap.put("95 RON, 92 RON", 1);
        surveyMap.put("98 RON", 24);
        surveyMap.put("Disel", 48);
        surveyMap.put("Gas", 4);
        model.addAttribute("surveyMap", surveyMap);
        return "graphfuel";
    }

    @RequestMapping("/displayPieChart")
    public String pieChart(Model model) {
        int all=681;
        model.addAttribute("pass", 67);
        model.addAttribute("fail", 33);
        return "Chart";
    }



}
