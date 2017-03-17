package com.yqz.webapp.annotation;

import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.annotation.RequestParamMethodArgumentResolver;

public class CaseInsensitiveRequestParamMethodArgumentResolver extends RequestParamMethodArgumentResolver {

	public CaseInsensitiveRequestParamMethodArgumentResolver(boolean useDefaultResolution) {
		super(useDefaultResolution);
		// TODO Auto-generated constructor stub
	}

	public CaseInsensitiveRequestParamMethodArgumentResolver(ConfigurableBeanFactory beanFactory,
			boolean useDefaultResolution) {
		super(beanFactory, useDefaultResolution);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Object resolveName(String name, MethodParameter parameter, NativeWebRequest request) throws Exception {
		Object arg = super.resolveName(name, parameter, request);
		if (arg == null) {
			String[] paramValues = getRequestParameterValues(request, name, false);
			if (paramValues != null) {
				arg = (paramValues.length == 1 ? paramValues[0] : paramValues);
			}
		}
		return arg;
	}

	private String[] getRequestParameterValues(NativeWebRequest request, String paramName, boolean caseSensitive) {
		if (caseSensitive)
			return request.getParameterValues(paramName);
		Set<Entry<String, String[]>> set = request.getParameterMap().entrySet();
		for (Entry<String, String[]> entry : set) {
			if (entry.getKey().equalsIgnoreCase(paramName))
				return entry.getValue();
		}
		return new String[0];
	}
}
