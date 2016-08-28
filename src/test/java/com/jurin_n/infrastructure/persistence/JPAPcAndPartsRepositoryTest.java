package com.jurin_n.infrastructure.persistence;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.jurin_n.domain.pcAndParts.Parts;
import com.jurin_n.domain.pcAndParts.Pc;
import com.jurin_n.junit.rules.JPAResource;

public class JPAPcAndPartsRepositoryTest {
    JPAPcAndPartsRepository sut;

    @Rule
    public JPAResource jpa = new JPAResource();

    @Before
    public void setUp() {
        sut = new JPAPcAndPartsRepository(jpa.getEm());
    }

    @After
    public void tearDown() {
        sut = null;
    }

    @Test
    public void test() {
        // パーツ作成とPC作成
        Parts parts1 = new Parts("PT001", "CPU");
        Parts parts2 = new Parts("PT002", "Fun");
        Pc pc1 = new Pc("P001", "Mac OS/X", Arrays.asList(parts1, parts2));
        Pc pc2 = new Pc("P002", "Mac OS/X 2016 version",
                Arrays.asList(parts1, parts2));
        jpa.getEm().getTransaction().begin();
        sut.persist(pc1);
        sut.persist(pc2);
        jpa.getEm().getTransaction().commit();
    }
}
