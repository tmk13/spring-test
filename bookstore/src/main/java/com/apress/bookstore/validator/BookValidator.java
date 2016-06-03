package com.apress.bookstore.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.apress.bookstore.entity.Book;

public class BookValidator implements Validator {
    @Override
	public boolean supports(Class<?> aClass) {
		return Book.class.equals(aClass);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        Book book = (Book) obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bookTitle", "field.required", "Nie może być pusta!");
		if (!errors.hasFieldErrors("bookTitle"))
			if (book.getBookTitle().isEmpty())
				errors.rejectValue("bookTitle", "", "Nie może być pusta!");
    }


}
