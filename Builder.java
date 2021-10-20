// Тестовый пользователь
class TestUser {
   private String department = "";
   private String position = "";
   private String role = "";
 
   public void setDepartment(String department) {
       this.department = department;
    }
   public void setPosition(String position) {
       this.position = position;
    }
   public void setRole(String role) {
       this.role = role;
    }
}
  
// Абстрактный билдер
abstract class TestUserBuilder {
   protected TestUser testUser;
 
   public TestUser getTestUser() {
       return testUser;
    }
   public void createNewTestUser() {
       testUser = new TestUser();
    }
 
   public abstract void buildDepartment();
   public abstract void buildPosition();
   public abstract void buildRole();
}
 
// Билдер для ПМ
class ProjectManagerTestUserBuilder extends TestUserBuilder {
   public void buildDepartment() {
       testUser.setDepartment("Administration");
    }
   public void buildPosition() {
       testUser.setPosition("ProjectManager");
    }
   public void buildRole() {
       testUser.setRole("Manager");
    }
}
 
// Билдер для тест-лида
class TestLeadTestUserBuilder extends TestUserBuilder {
   public void buildDepartment() {
       testUser.setDepartment("QA");
    }
   public void buildPosition() {
       testUser.setPosition("Tester");
    }
   public void buildRole() {
       testUser.setRole("Expert");
    }
}

// Образец тестового пользователя
class TestUserSample {
   private TestUserBuilder testUserBuilder;
 
   public void setTestUserBuilder(TestUserBuilder employee) {
       testUserBuilder = employee;
    }
   public TestUser getTestUser() {
       return testUserBuilder.getTestUser();
    }
 
   public void constructTestUser() {
      testUserBuilder.createNewTestUser();
      testUserBuilder.buildDepartment();
      testUserBuilder.buildPosition();
      testUserBuilder.buildRole();
   }
}

// Создание экземпляра тестового пользователя
public class BuilderExample {
   public static void main(String[] args) {
       TestUserSample sample = new TestUserSample();
       TestUserBuilder employee = new ProjectManagerTestUserBuilder();
       sample.setTestUserBuilder(employee);
       sample.constructTestUser();
 
       TestUser testUser = sample.getTestUser();
   }
}