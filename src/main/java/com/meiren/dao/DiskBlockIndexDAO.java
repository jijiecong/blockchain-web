package com.meiren.dao;

import com.meiren.dataobject.DiskBlockIndexDO;

import java.util.List;
import java.util.Map;

/**
 * DiskBlockIndexDAO
 * @author jijc
 */
public interface DiskBlockIndexDAO {
    /**
     * create.
     * @param diskBlockIndexDO {@link DiskBlockIndexDO}
     * @return id
     */
    public Long create(DiskBlockIndexDO diskBlockIndexDO);


    /**
     * findByBlockHash.
     * @param blockHash
     * @return {@link DiskBlockIndexDO}
     */
    public DiskBlockIndexDO findByBlockHash(String blockHash) ;

    /**
     * findByPrevBlockHash.
     * @param prevBlockHash
     * @return {@link DiskBlockIndexDO}
     */
    public DiskBlockIndexDO findByPrevBlockHash(String prevBlockHash) ;

    /**
     * findByNextBlockHash.
     * @param nextBlockHash
     * @return {@link DiskBlockIndexDO}
     */
    public DiskBlockIndexDO findByNextBlockHash(String nextBlockHash) ;

    /**
     * getLastestBlockIndex.
     * @return {@link DiskBlockIndexDO}
     */
    public DiskBlockIndexDO getLastestBlockIndex() ;

    /**
     * modifyByBlockHash.
     * @param modifyMap
     * @return {@link int}
     */
    public int modifyByBlockHash(Map modifyMap) ;

    /**
     * getMaxnFile.
     * @return {@link int}
     */
    public int getMaxnFile() ;

    /**
     * searchDiskBlockIndex.
     * @return {@link List<DiskBlockIndexDO>}
     */
    public List<DiskBlockIndexDO> searchDiskBlockIndex() ;
}
