package com.licorice.view;

import java.io.OutputStream;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

public class MappingJackson2JsonpView extends MappingJackson2JsonView {
	/**
	* Default content type. Overridable as bean property.
	*/	
	public static final String DEFAULT_CONTENT_TYPE = "application/javascript";
	 
	public MappingJackson2JsonpView() {
		super();
	}
	
	@Override
	public String getContentType() {	
		return DEFAULT_CONTENT_TYPE;	
	}
	
	@Override
	public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		if( "GET".equals(request.getMethod().toUpperCase()) ) {
			Map<String, String[]> params = request.getParameterMap();
			if ( params.containsKey("callback") ) {
				OutputStream out = response.getOutputStream();
				out.write((params.get("callback")[0] + "(").getBytes());
				super.render(model, request, response);
				out.write((")").getBytes());
				response.setContentType("application/javascript");
			} else {
				super.render(model, request, response);
			}			
		} else {
			super.render(model, request, response);
		}
	}
	
	@Override 
	protected Object filterModel(Map<String, Object> model) {
		Set<Object> result = new HashSet<Object>(model.size());
		Set<String> renderedAttributes = (!CollectionUtils.isEmpty(getModelKeys()) ? getModelKeys() : model.keySet());
		for (Map.Entry<String, Object> entry : model.entrySet()) {
			if (!(entry.getValue() instanceof BindingResult) && renderedAttributes.contains(entry.getKey())) {
				result.add(entry.getValue());
			}
		}
		return result;
	}
}
