package ru.gb.interview.dto;


import lombok.*;

import java.util.Objects;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private Long id;
    private String name;
    private int age;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass() && getClass() != o.getClass().getSuperclass()) return false;
        StudentDto studentDto = (StudentDto) o;
        return id.equals(studentDto.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,name,age);
    }


}
