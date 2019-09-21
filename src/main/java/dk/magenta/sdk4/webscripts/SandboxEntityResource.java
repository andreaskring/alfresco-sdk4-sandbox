package dk.magenta.sdk4.webscripts;

import org.alfresco.repo.security.authentication.AuthenticationUtil;
import org.alfresco.rest.api.Nodes;
import org.alfresco.rest.api.model.Node;
import org.alfresco.rest.framework.WebApiNoAuth;
import org.alfresco.rest.framework.core.exceptions.EntityNotFoundException;
import org.alfresco.rest.framework.resource.EntityResource;
import org.alfresco.rest.framework.resource.actions.interfaces.EntityResourceAction;
import org.alfresco.rest.framework.resource.actions.interfaces.MultiPartResourceAction;
import org.alfresco.rest.framework.resource.parameters.Parameters;
import org.alfresco.rest.framework.webscripts.WithResponse;
import org.springframework.extensions.webscripts.servlet.FormData;

@EntityResource(name = "sandbox", title = "Sandbox")
public class SandboxEntityResource implements EntityResourceAction.ReadById<Node>,
        MultiPartResourceAction.Create<Node> {

    private Nodes nodes;

    @Override
    @WebApiNoAuth
    public Node readById(String id, Parameters parameters) throws EntityNotFoundException {
        return AuthenticationUtil.runAsSystem(() -> nodes.getFolderOrDocument(id, parameters));
    }

    @Override
    @WebApiNoAuth
    public Node create(FormData formData, Parameters parameters, WithResponse withResponse) {
        System.out.println("multipart");
        return new Node();
    }

    public void setNodes(Nodes nodes) {
        this.nodes = nodes;
    }
}
