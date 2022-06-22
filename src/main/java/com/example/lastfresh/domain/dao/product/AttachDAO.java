package com.example.lastfresh.domain.dao.product;


import com.example.lastfresh.mapper.product.AttachMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AttachDAO {
    private final AttachMapper attachMapper;
//    public void register(AttachVO attachVO){
//        attachMapper.insert(attachVO);
//    }
//    public void remove(String uuid){
//        if(uuid == null) {return;}
//        attachMapper.delete(uuid);
//    }
//    public List<AttachVO> selectAllByBno(Long bno){
//        return attachMapper.select(bno);
//    }
//    public String getUUID(Long bno) { return attachMapper.getUUID(bno); }
//    public List<AttachVO> getOldFiles() { return attachMapper.getOldFiles(); }
}
