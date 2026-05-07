package com.abdullah.BiblioBook.mapper;

import com.abdullah.BiblioBook.dto.request.CreateBookRequest;
import com.abdullah.BiblioBook.dto.request.UpdateBookRequest;
import com.abdullah.BiblioBook.dto.response.BookResponse;
import com.abdullah.BiblioBook.entity.Book;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface BookMapper {

    Book toEntity(CreateBookRequest request);

    BookResponse toResponse(Book book);

    @BeanMapping
    (nullValuePropertyMappingStrategy
    = NullValuePropertyMappingStrategy.IGNORE)
    void updateBookFromDto(UpdateBookRequest request, @MappingTarget Book book);
}

