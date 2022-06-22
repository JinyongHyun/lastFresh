package com.example.lastfresh.domain.dao.owner;


import com.example.lastfresh.mapper.owner.OwnerAttachMapper;
import com.example.lastfresh.mapper.product.AttachMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OwnerAttachDAO {
    private final OwnerAttachMapper ownerattachMapper;
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
