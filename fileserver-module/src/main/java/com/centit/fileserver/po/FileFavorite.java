package com.centit.fileserver.po;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * create by scaffold 2020-08-18 13:38:14
 * @author codefan@sina.com

  文件收藏
*/
@Data
@Entity
@Table(name = "FILE_FAVORITE")
public class FileFavorite implements java.io.Serializable {
	private static final long serialVersionUID =  1L;



	/**
	 * 收藏id 收藏id
	 */
	@Id
	@Column(name = "favorite_id")
	private String favoriteId;

	/**
	 * 文件ID 文件ID
	 */
	@Column(name = "file_id")
	private String  fileId;
	/**
	 * 收藏人 收藏人
	 */
	@Column(name = "favorite_user")
	private String  favoriteUser;
	/**
	 * 收藏时间 收藏时间
	 */
	@Column(name = "favorite_time")
	private java.sql.Date  favoriteTime;


	public FileFavorite copy(FileFavorite other){



		this.setFavoriteId(other.getFavoriteId());


		this.fileId= other.getFileId();
		this.favoriteUser= other.getFavoriteUser();
		this.favoriteTime= other.getFavoriteTime();

		return this;
	}

	public FileFavorite copyNotNullProperty(FileFavorite other){



	if( other.getFavoriteId() != null)
		this.setFavoriteId(other.getFavoriteId());

		if( other.getFileId() != null)
			this.fileId= other.getFileId();
		if( other.getFavoriteUser() != null)
			this.favoriteUser= other.getFavoriteUser();
		if( other.getFavoriteTime() != null)
			this.favoriteTime= other.getFavoriteTime();

		return this;
	}

	public FileFavorite clearProperties(){

		this.fileId= null;
		this.favoriteUser= null;
		this.favoriteTime= null;

		return this;
	}
}