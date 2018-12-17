package com.dsebproj.recipesite.siteuser;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiteUserRepository extends CrudRepository<SiteUser, Long> {

}
