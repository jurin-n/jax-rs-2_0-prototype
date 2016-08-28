package com.jurin_n.infrastructure.persistence;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.jurin_n.domain.pcAndParts.Parts2;
import com.jurin_n.domain.pcAndParts.Pc2;
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
        Parts2 parts1 = new Parts2("PT001", "CPU");
        Parts2 parts2 = new Parts2("PT002", "Fun");
        Pc2 pc1 = new Pc2("P001", "Mac OS/X", Arrays.asList(parts1, parts2));
        Pc2 pc2 = new Pc2("P002", "Mac OS/X 2016 version",
                Arrays.asList(parts1, parts2));
        jpa.getEm().getTransaction().begin();
        sut.persist(pc1);
        sut.persist(pc2);
        jpa.getEm().getTransaction().commit();
    }
}
