package com.lambdaschool.orders.repos;

import com.lambdaschool.orders.model.Agent;
import org.springframework.data.repository.CrudRepository;

public interface Agentrepo extends CrudRepository<Agent, Long>
{
}
