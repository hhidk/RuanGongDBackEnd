package com.scholar.social.repository;

import com.scholar.social.util.Sector;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
public class SectorRepositoryTests {
    @Autowired
    private SectorRepository sectorRepository;

    @Test
    void testGetAll() {
        List<Sector> sectors = sectorRepository.getAll();
        Assert.isTrue(sectors.size() == 3, "missing sectors");
        for (int i = 0; i < sectors.size(); i++) {
            Assert.isTrue(i + 1 == sectors.get(i).getId(), "wrong Id");
        }
    }

    @Test
    void testGetTot() {
        int tot = sectorRepository.getTot(1);
        Assert.isTrue(tot == 0, "failed");
    }

    @Test
    void testModifyTot() {
        sectorRepository.setTot(1, 1000);
        int tot = sectorRepository.getTot(1);
        Assert.isTrue(tot == 1000, "set failed");
        sectorRepository.setTot(1, 0);
        tot = sectorRepository.getTot(1);
        Assert.isTrue(tot == 0, "set failed");
    }
}
