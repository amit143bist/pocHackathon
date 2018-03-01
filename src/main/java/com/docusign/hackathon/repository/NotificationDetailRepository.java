package com.docusign.hackathon.repository;

import org.springframework.data.repository.CrudRepository;

import com.docusign.hackathon.db.model.NotificationDetail;
import com.docusign.hackathon.db.model.NotificationDetailPK;

public interface NotificationDetailRepository extends CrudRepository<NotificationDetail, NotificationDetailPK> {

}