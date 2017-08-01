package com.centit.fileserver.service.impl;

import com.centit.fileserver.dao.FileStoreInfoDao;
import com.centit.fileserver.po.FileShowInfo;
import com.centit.fileserver.service.LocalFileManager;
import com.centit.framework.components.CodeRepositoryUtil;
import com.centit.framework.model.basedata.IUnitInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

/**
 * Created by codefan on 17-1-17.
 */
@Service("localFileManager")
@Transactional
public class LocalFileManagerImpl implements LocalFileManager {

    @Resource(name ="fileStoreInfoDao")
    @NotNull
    protected FileStoreInfoDao fileStoreInfoDao;

    @Override
    public Set<IUnitInfo> listUserUnit(String userCode) {
        return CodeRepositoryUtil.getUserUnits(userCode);
    }

    @Override
    public List<FileShowInfo> listUserFiles(String userCode, String fileShowPath) {
        List<FileShowInfo> files = fileStoreInfoDao.listUserFiles(userCode,fileShowPath);
        Set<String> dirs = fileStoreInfoDao.listUserDirectories(userCode,fileShowPath);
        if(dirs !=null){
            for(String dir : dirs) {
                FileShowInfo file = new FileShowInfo();
                file.setFileShowPath(fileShowPath+ LocalFileManager.FILE_PATH_SPLIT +dir);
                file.setCatalogType("p");
                file.setFileType("d");
                file.setFileName(dir);
                files.add(file);
            }
        }
        return files;
    }

    @Override
    public List<FileShowInfo> listUnitFiles(String unitCode, String fileShowPath) {
        List<FileShowInfo> files = fileStoreInfoDao.listUnitFiles(unitCode,fileShowPath);
        Set<String> dirs = fileStoreInfoDao.listUnitDirectories(unitCode,fileShowPath);
        if(dirs !=null){
            for(String dir : dirs) {
                FileShowInfo file = new FileShowInfo();
                file.setFileShowPath(fileShowPath + LocalFileManager.FILE_PATH_SPLIT + dir);
                file.setCatalogType("d");
                file.setFileType("d");
                file.setFileName(dir);
                files.add(file);
            }
        }
        return files;
    }

    @Override
    public List<FileShowInfo> listUserFileVersions(String userCode, String fileShowPath, String fileName) {
        return fileStoreInfoDao.listUserFileVersions(userCode, fileShowPath, fileName);
    }

    @Override
    public List<FileShowInfo> listUnitFileVersions(String unitCode, String fileShowPath, String fileName) {
        return fileStoreInfoDao.listUnitFileVersions(unitCode, fileShowPath, fileName);
    }

}
