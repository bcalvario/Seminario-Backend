import java.util.*;

public class Category {
    
    String category_id;  
    String category;  
    
    Category (String categoryId, String categoryName) {
        
        category_id = categoryId;
        category = categoryName;
    
    }

    Category () {}
    
    public static void main(String args[]) {
        
        ArrayList<Category> categories = new ArrayList<Category>();
        
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        try {
            do{
                System.out.println("\n\n\n\n\n\n");
                System.out.println("Menú:");
                System.out.println("1) Crear una nueva categoria");
                System.out.println("2) Listar todas las categorias");
                System.out.println("3) Obtener una categoria");
                System.out.println("4) Borrar categoria");
                System.out.println("4. Salir");
                System.out.println("Escribe una de las opciones");
    
                int option = scanner.nextInt();
                
                switch(option){
                    case 1:

                        System.out.println("Escribe el id de la categoria:");

                        String categoryId = scanner.nextLine();

                        Thread.sleep(100 * 1000);

                        System.out.println("Escribe el la categoria:");

                        String category = scanner.nextLine();

                        Thread.sleep(100 * 1000);

                        categories.add(createCategory(categoryId, category));
                        
                        break;

                    case 2:

                        System.out.println(getCategories(categories));

                        break;

                    case 3:
                        System.out.flush(); 
                        System.out.println("Has seleccionado la opcion 3");
                        break;
                    case 4:
                        System.out.flush(); 
                        salir=true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 4");
                }
            }
            while(!salir);
        } catch (Exception e) {
            // TODO: handle exception
        }
    











    }
    
    public static Category createCategory(String categoryId, String categoryName) {
        
        return new Category(categoryId, categoryName);
    
    }
    
    public static String getCategories(ArrayList<Category> categories) {
        
        if (categories.size() == 0) {
            return "No existen categorias registradas";
        } else {
            String categoriesString = "(";
        
        for (int i = 0; i < categories.size(); i++) {
            categoriesString += "(" + categories.get(i).category_id + ", " + categories.get(i).category + ")";
        }
        
        return categoriesString;
        }
    }

    public static String getCategory(String categoryId, ArrayList<Category> categories) {
        
        Category category = new Category();

        for (int i = 0; i < categories.size(); i++) {
            
            if (categories.get(i).category_id.equals(categoryId)) {

                category.category_id = categories.get(i).category_id;
                category.category = categories.get(i).category;
                break;
            }
        
        }
        
        return "(" + category.category_id + ", " + category.category + ")";

    }

    public static void deleteCategory(String categoryId, ArrayList<Category> categories) {

        for (int i = 0; i < categories.size(); i++) {
            
            if (categories.get(i).category_id.equals(categoryId)) {

                categories.remove(i);
                break;
            }
        
        }

    }
}