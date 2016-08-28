package com.jurin_n.domain.parts;

public interface PartsRepository {
    public Parts findById(String id);

    public void persist(Parts parts);
}
