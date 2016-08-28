package com.jurin_n.infrastructure.persistence;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.jurin_n.domain.parts.Parts;
import com.jurin_n.domain.pc.Pc;
import com.jurin_n.domain.pc.PcParts;
import com.jurin_n.junit.rules.JPAResource;

public class JPAPcRepositoryTest {
    JPAPcRepository sut1;
    JPAPartsRepository sut2;

    @Rule
    public JPAResource jpa = new JPAResource();

    @Before
    public void setUp() {
        sut1 = new JPAPcRepository(jpa.getEm());
        sut2 = new JPAPartsRepository(jpa.getEm());
    }

    @After
    public void tearDown() {
        sut1 = null;
        sut2 = null;
    }

    @Test
    public void test() {
        // パーツ登録
        Parts parts1 = new Parts("PARTS-001", "CPU");
        Parts parts2 = new Parts("PARTS-002", "Fun");

        jpa.getEm().getTransaction().begin();
        sut2.persist(parts1);
        sut2.persist(parts2);
        // データベースへの反映,コンテキスト破棄
        jpa.getEm().flush();
        jpa.getEm().clear();
        jpa.getEm().getTransaction().commit();

        // PC登録(PC-PARTS表作る -> PC-PARTS登録してPC作成　-> PC-PARTS表にPCの参照登録)
//        PcParts pc1Parts1 = new PcParts("PCPARTS-PC1-001", parts1.getId());
//        PcParts pc1Parts2 = new PcParts("PCPARTS-PC1-002", parts2.getId());
//        Pc pc1 = new Pc("PC-001", "Mac OS/X",
//                Arrays.asList(pc1Parts1, pc1Parts2));
//        pc1Parts1.setPc(pc1);
//        pc1Parts2.setPc(pc1);
//
//        PcParts pc2Parts1 = new PcParts("PCPARTS-PC2-001", parts1.getId());
//        PcParts pc2Parts2 = new PcParts("PCPARTS-PC2-002", parts2.getId());
//        Pc pc2 = new Pc("PC-002", "Mac OS/X new version",
//                Arrays.asList(pc2Parts1, pc2Parts2));
//        pc2Parts1.setPc(pc2);
//        pc2Parts2.setPc(pc2);

        // PC登録(PC作成 -> PC-PARTS表作成 -> PCにPC-PARTS表登録)
        Pc pc1 = new Pc("PC-001", "Mac OS/X");
        PcParts pc1Parts1 = new PcParts("PCPARTS-PC1-001", parts1.getId(), pc1);
        PcParts pc1Parts2 = new PcParts("PCPARTS-PC1-002", parts2.getId(), pc1);
        pc1.setPcParts(Arrays.asList(pc1Parts1, pc1Parts2));

        Pc pc2 = new Pc("PC-002", "Mac OS/X new version");
        PcParts pc2Parts1 = new PcParts("PCPARTS-PC2-001", parts1.getId(), pc2);
        PcParts pc2Parts2 = new PcParts("PCPARTS-PC2-002", parts2.getId(), pc2);
        pc2.setPcParts(Arrays.asList(pc2Parts1, pc2Parts2));
        
        jpa.getEm().getTransaction().begin();
        sut1.persist(pc1);
        sut1.persist(pc2);
        jpa.getEm().getTransaction().commit();
    }
}
