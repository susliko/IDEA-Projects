public class gh {

    public static String printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder sorted = new StringBuilder();

            for (String role : roles)
            {
                sorted.append(role).append(":\n");
                for (int i = 0; i < textLines.length; i++)
                {
                    if (role.regionMatches(0,textLines[i],0,role.length()) && textLines[i].charAt(role.length()) == ':')
                    {
                        sorted.append(i+1).append(")").append(textLines[i].substring(role.length()+1)).append("\n");
                    }
                }
                sorted.append("\n");
            }
        return sorted.toString();
    }

    public static void main(String[] args) {
        String[] roles = {"Городничий","Аммос Федорович","Артемий Филиппович","Лука Лукич"};
        String[] textLines = {
                "Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
                "Аммос Федорович: Как ревизор?",
                "Артемий Филиппович: Как ревизор?",
                "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
                "Аммос Федорович: Вот те на!",
                "Артемий Филиппович: Вот не было заботы, так подай!",
                "Лука Лукич: Господи боже! еще и с секретным предписаньем!"
        };
        System.out.println(printTextPerRole(roles, textLines));
    }
}