package test;
import main.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class testHashMap {

    @Test
    public void testHashFunction(){
        HashMap testMap = new HashMap();
        GraphNode testNode = new GraphNode("3901DI92-DG23", false);
        GraphNode testNode2 = new GraphNode("526A8F9G-G98Q", false);
        Entry testEntry = new Entry(testNode, 1);
        Entry testEntry2 = new Entry(testNode2, 2);
        testMap.set(testNode, 1);
        assertTrue(testEntry.equals(testMap.getEntry(testNode)));
        testMap.set(testNode2, 2);
        assertTrue(testEntry2.equals(testMap.getEntry(testNode2)));
    }

    @Test
    public void testRehash(){
        HashMap testMap = new HashMap(5);
        testMap.set(new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91", false), 1);
        testMap.set(new GraphNode("30bede1a-11ce-4af2-b190-59082acce682", false), 2);
        testMap.set(new GraphNode("6bb67358-3761-455c-b283-2d309ca375e6", false), 5);
        testMap.set(new GraphNode("46af266f-5d0c-43a1-9f91-4b00ca25f6b3", false), 4);
        assertEquals(testMap.numEntries(), 4);
        testMap.set(new GraphNode("4ba797c7-5b24-4577-82b6-ac39152c8423", false),7);
        testMap.set(new GraphNode("a733a462-a578-4374-bdc3-920733a6eafc", false), 6);
        testMap.set(new GraphNode("d4b2fd29-6869-4a38-935b-2d537830e30b", false), 3);
        assertEquals(testMap.getValue(new GraphNode("d4b2fd29-6869-4a38-935b-2d537830e30b", false)), 3);
        assertEquals(testMap.getValue(new GraphNode("a733a462-a578-4374-bdc3-920733a6eafc", false)), 6);
        assertEquals(testMap.getValue(new GraphNode("4ba797c7-5b24-4577-82b6-ac39152c8423", false)),7);
        assertEquals(testMap.getValue(new GraphNode("46af266f-5d0c-43a1-9f91-4b00ca25f6b3", false)), 4);
        assertEquals(testMap.getValue(new GraphNode("6bb67358-3761-455c-b283-2d309ca375e6", false)), 5);
        assertEquals(testMap.getValue(new GraphNode("30bede1a-11ce-4af2-b190-59082acce682", false)), 2);
        assertEquals(testMap.getValue(new GraphNode("c4dbe07b-f0b5-4b8a-bf11-28780d609a91", false)), 1);
        //Should still keep all key value pairs after rehashing 
    }
// d4b2fd29-6869-4a38-935b-2d537830e30b f03af39a-4bd5-4e50-86ec-6ec2f2dcf24e 6ec0919a-11ba-418a-b81d-2b4bc2443850 37420837-eb1e-43e8-a8f2-ac464a413195 f4e1dd1e-1397-4b8e-b1b2-9a975ab8adec 8c3f9ba1-fe90-4102-82ab-1f3c2e60ea7d 262c6587-096c-4e26-90b0-2d395b1f2f5c f1158079-1f0a-4f9e-898c-e33bd0f6e04c 17c1e51c-550d-453f-862f-6445071cb2de 22bea985-2d6b-4f9c-80f5-15001db7b822 cad6d012-0f16-46c1-9723-65f5e31998a7 195f6d1b-c64f-4435-aa0f-e76d0cbb0b93 8ea580b4-070b-41bc-9b24-60a9d9e2939f 02a4e739-79ce-4140-a108-cfe3715eaa72 2b8b7726-9d17-479f-b377-8a49e13cf44f b7c17c64-458b-4c89-9c64-7e8298ded257 11b3183e-4ccb-48ba-b619-903bea43e4b9 47ee9be1-7a77-4ec4-8d6c-cf74c9d973db 811dce9c-7731-448c-94fd-6c2adf410e9f c44d8e94-641e-423a-b297-ed65617dd69e 2500e04a-0a4e-46b5-bd3d-12257f95c9d7 1942f2e9-df31-44df-b890-8593ba08c745 75e6dd3c-fcb5-4fbc-9011-d94327f41803 90e7342a-541b-48b9-a84f-a70eb8aa104f f1161abe-bd42-4b02-a333-9fa67badc028 7e183c0b-d0d3-4ab2-94a0-c22a8ac7653d 8f0c07c9-6164-4127-a57f-976730db681e 058f597c-f9b1-457c-afe8-0f2becf51424 d060dbd6-49a0-4880-a986-46e13cb7738e 0e9a9d94-b845-403b-a88c-aee8a6996317 2fcff296-8797-427d-808a-f3f561b92206 2f7f9317-3b53-4d3a-8092-9b0779fd2c1f 75bad8a0-8ac7-4b2c-9dfa-72e875399c90 53705ce6-0838-4318-8b67-50989d063e96 8f1a507e-b755-4535-9bdb-24a82ab2acf3 fc1b14a2-9462-4766-9d1d-ca5cbf96d15e 238e26e5-6ad8-4c37-928f-e31cc62f7583 66271f0e-0d4c-45f5-ae9f-12d7bb76f0a1 36abe4f4-50fa-4e64-ae5a-49d63972b7de cd0a6771-5b20-4fff-9993-6df1ad71f36d 0586d58e-38c4-4ca9-9a2b-673d5b55390e 8c5a70e0-5c43-4304-a589-ba9068c5f773 2bdcaac7-d0a6-4b0e-a3a8-a90d7d66c688 79fb39f5-70db-4698-9954-1431ae5689b7 3ba80a39-24c5-4f3d-868d-1da499b097a2 9dab7b3d-3b76-4631-b648-f7a427bb88d9 e1f6febb-5dbf-4802-b531-aa08af04b2f0 8fe2b48d-4ba3-4680-a2f8-11b45d3afd39 8b8b5aaa-6d43-489f-901d-1067ec9f66cf 0f5e0427-cd83-4489-b615-e663e2591d14 7cd23ff7-55cf-4bbe-8604-16532a3585a2 7d830544-ccd9-44f2-90ff-78d13742fd6d 901b15ed-7397-4d95-91bd-de7d84783580 15a12631-9244-47b8-910c-47d190db1d41 a09932c5-87cb-46e1-88b9-9cc7cc9ebf37 fb29f4ce-ed6a-4280-a990-82b1423e3a51 2d2c9310-210a-4f1b-b019-a9ca8ad5f5d5 d1bdf447-29b4-4c69-8702-521aa125c503 a3e9a92a-82d5-4c94-90f7-846b3acd163f 13f480ea-7811-4461-be93-d7cc3c7a86cb 91eb2c6a-478d-4fd4-a810-16aa4d84cb56 ad45f53b-13a8-44fd-80e7-63eac1b6ef04 f83d8f54-e3c5-462c-9b67-47ea38304da2 2f8c5331-6883-49a1-8f90-0e76e1c0e2e3 3b70b8ac-f2c2-43fa-9375-7bd34eb90815 3e47b060-bdfc-4c6a-b2a9-4850086440eb 44b7e459-fe0f-407c-bc93-5633c95819f2 ab805f66-5a73-4d45-9345-93b3fec1e321 d0f2af47-8f77-4699-a6f0-56219143caf7 68014243-b865-4978-8aaf-ccbf6061ca7e cc6fcf0d-6d21-4037-9e94-7b9d78c9fcec 5de341cc-be19-4dfe-95b2-d4e3c04cb56e 72f117d0-fa31-47b4-930d-34f59730c0fd 6f65ae96-ca49-427d-b695-ae7e078506af d6f306ac-c67f-4eeb-87e9-13ed2879c8ba 469fd63b-064f-49d4-ad97-4b1011742e9b 593611ce-24cb-4a55-b987-84b2ecc5fc9c 50129b94-24fa-4430-8cf7-ed72ed443f17 9cb34c03-680d-4f65-92dc-e826b9cdd378 5f459f7d-60f7-4a32-b9e8-82ef55dab93f 4e62637b-c1d1-4292-a62b-b1e7617f14bf d17af073-666e-4919-826b-b50fb46ef6e5 35cfb233-a9be-4b76-83b8-329d14cf8cd3 c1a3da13-c870-450c-af74-fd4206256c77 172dc6e1-ca72-4938-8a46-9d7a25f39d49 1842cbec-bca2-4c14-a4ed-c35f25cab250 18d98eae-e487-4d3f-9377-68631eef384b 08969e87-2f83-4451-a99c-0ccf96da1027 5911189e-4f30-4b60-83f4-c0619ca61683 53666ab8-5850-4661-bb18-ffe5b9aa1b66 7f96728d-9901-4722-b296-60a1bf2e941c 2846f07e-a2cd-4dfe-85fd-8ddd36cac468 486ad647-99e4-499e-a1b4-00be7da83dd1 a25a2de4-aba2-44f2-9016-ea3fad652d23 


}