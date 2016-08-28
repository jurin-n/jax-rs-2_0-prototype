package com.jurin_n.infrastructure.persistence;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.jurin_n.domain.pcAndParts.Parts;
import com.jurin_n.domain.pcAndParts.Pc;
import com.jurin_n.junit.rules.JPAResource;

public class JPAPcRepositoryTest {
    JPAPcRepository sut;

    @Rule
    public JPAResource jpa = new JPAResource();

    @Before
    public void setUp() {
        sut = new JPAPcRepository(jpa.getEm());
    }

    @After
    public void tearDown() {
        sut = null;
    }

    @Test
    public void test() {
        // パーツ登録
        Parts p1 = new Parts("PT001", "CPU");
        Parts p2 = new Parts("PT002", "Fun");

        jpa.getEm().getTransaction().begin();
        jpa.getEm().persist(p1);
        jpa.getEm().persist(p2);
        // データベースへの反映,コンテキスト破棄
        jpa.getEm().flush();
        jpa.getEm().clear();
        jpa.getEm().getTransaction().commit();

        // パーツ使いPC登録
        Parts parts1 = jpa.getEm().find(Parts.class, "PT001");
        Parts parts2 = jpa.getEm().find(Parts.class, "PT002");
        Pc pc1 = new Pc("P001", "Mac OS/X", Arrays.asList(parts1, parts2));
        Pc pc2 = new Pc("P002", "Mac OS/X 2016 version",
                Arrays.asList(parts1, parts2));
        jpa.getEm().getTransaction().begin();
        sut.persist(pc1);
        sut.persist(pc2);
        jpa.getEm().getTransaction().commit();
    }
}
