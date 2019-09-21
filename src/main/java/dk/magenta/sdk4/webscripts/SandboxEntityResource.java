package dk.magenta.sdk4.webscripts;

import org.alfresco.rest.api.Nodes;
import org.alfresco.rest.api.model.Node;
import org.alfresco.rest.framework.core.exceptions.EntityNotFoundException;
import org.alfresco.rest.framework.resource.EntityResource;
import org.alfresco.rest.framework.resource.actions.interfaces.EntityResourceAction;
import org.alfresco.rest.framework.resource.parameters.Parameters;

@EntityResource(name = "sandbox", title = "Sandbox")
public class SandboxEntityResource implements EntityResourceAction.ReadById<Node> {

    private Nodes nodes;

    @Override
    public Node readById(String id, Parameters parameters) throws EntityNotFoundException {
        return nodes.getFolderOrDocument(id, parameters);
    }

    public void setNodes(Nodes nodes) {
        this.nodes = nodes;
    }
}
