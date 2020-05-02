
package com.satyendra.iris.zoo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satyendra.iris.zoo.dao.IPenDao;
import com.satyendra.iris.zoo.dao.IZooDao;
import com.satyendra.iris.zoo.model.Pen;
import com.satyendra.iris.zoo.model.Zoo;
import com.satyendra.iris.zoo.request.dto.PenRequestDto;
import com.satyendra.iris.zoo.request.dto.ZooRequestDto;
import com.satyendra.iris.zoo.services.IZooAndPenService;

@Service
public class ZooManagementService implements IZooAndPenService {

    @Autowired
    public IZooDao zooService;

    @Autowired
    public IPenDao penService;

    @Override
    public void addZooSpace(ZooRequestDto zoo) {

        Zoo z = new Zoo();
        z.name = zoo.getName();
        int id = zooService.addZoo(z);
        System.out.print("zoo Id:"+ id);
    }

    @Override
    public List<Zoo> getAllZooSpaces() {

        return zooService.list();
    }

    @Override
    public void addPen(PenRequestDto penDto) {
        Pen pen = new Pen();
        pen.setName(penDto.getPenName());
        Zoo zoo  = new Zoo();
        zoo.setId(penDto.getZooId());
        pen.setZoo(zoo);
        penService.addPen(pen);

    }

    @Override
    public List<Pen> allPegsFromZoo(int zooid) {
        return penService.list(zooid);
    }

}
