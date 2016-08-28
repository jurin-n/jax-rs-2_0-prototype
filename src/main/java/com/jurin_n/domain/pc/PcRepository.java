package com.jurin_n.domain.pc;

public interface PcRepository {
    public Pc findById(String id);

    public void persist(Pc pc);
}
