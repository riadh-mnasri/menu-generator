package com.github.rmnasri.validator;

import com.github.rmnasri.controller.RecetteForm;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by riadh on 10/05/15.
 */
@Component
public class RecetteValidator implements Validator {

    @Override
    public boolean supports(Class clazz) {
        return RecetteForm.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        if (obj != null) {
            RecetteForm recetteForm = (RecetteForm) obj;
            if (StringUtils.isEmpty(recetteForm.getRecetteName())) {
                errors.rejectValue("recetteName", "recette.name.required");
            }
        }
    }
}
