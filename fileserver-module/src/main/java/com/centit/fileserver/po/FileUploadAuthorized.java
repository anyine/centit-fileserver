package com.centit.fileserver.po;

import com.centit.support.database.orm.GeneratorType;
import com.centit.support.database.orm.ValueGenerator;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name= "FILE_UPLOAD_AUTHORIZED")
public class FileUploadAuthorized implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name ="UPLOAD_TOKEN")
    @ValueGenerator(strategy = GeneratorType.UUID)
    private String uploadToken;

    @Column(name="MAX_UPLOAD_FILES")
    private Integer maxUploadFiles;

    @Column(name="REST_UPLOAD_FILES")
    private Integer restUploadFiles;

    @Column(name="CREATE_TIME")
    private Date craeteTime;

    @Column(name="LAST_UPLOAD_TIME")
    private Date lastUploadTime;

    public FileUploadAuthorized(){
        maxUploadFiles = 1;
        restUploadFiles = 1;
    }

}
