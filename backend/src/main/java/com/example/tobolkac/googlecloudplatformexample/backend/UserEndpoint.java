package com.example.tobolkac.googlecloudplatformexample.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiNamespace;

/**
 * Created by clayt on 2/1/15.
 */
@Api(name = "user", version = "v1", namespace = @ApiNamespace(ownerDomain = "backend.googlecloudplatformexample.tobolkac.example.com",
        ownerName = "backend.googlecloudplatformexample.tobolkac.example.com", packagePath = ""))
public class UserEndpoint
{

}
