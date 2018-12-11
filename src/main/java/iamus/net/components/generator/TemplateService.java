package iamus.net.components.generator;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iamus.net.components.component.Component;
import iamus.net.components.property.Property;



@Service
public class TemplateService {
	
	@Autowired
	public TemplateRepository TemplateRepository;
	
	public List <Template> getAllTemplates() {
		
		List <Template> Templates = new ArrayList<>();
		 TemplateRepository.findAll()
		 .forEach(Templates::add);			
		 return Templates;
	}
	
		public List<Template> getTemplates(String id) {
		
		List <Template> Templates = new ArrayList<>();
		 TemplateRepository.findBySearchTermNative(id)
		.forEach(Templates::add);
		return Templates;
	}
	
	
	public Optional<Template> getTemplate(int id) {
		return TemplateRepository.findById(id);
	}
	

	public void createTemplate(Component component) {
		Template template = new Template();
		template.setComponentTemplate(
				component.propertiesToString() +
				component.GettersSettersToString() +
				component.ConstructorToString()
				);
		TemplateRepository.save(template);
	}

	public void updateTemplate(Template Template, String id) {
		TemplateRepository.save(Template); 
		
	}

	public void deleteTemplate(int id) {
		
		TemplateRepository.deleteById(id);
	}

	public void createTemplate(Template template) {
		TemplateRepository.save(template);
		
	}
	
}