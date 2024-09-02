import javax.swing.JOptionPane;

public class notas {
    public static void main(String[] args) {
        try {
            // Solicitar la cantidad de notas
            String cantidadNotasStr = JOptionPane.showInputDialog(null, "Ingrese la cantidad de notas:");
            int cantidadNotas = Integer.parseInt(cantidadNotasStr);
            
            // Verificar que la cantidad de notas sea positiva
            if (cantidadNotas <= 0) {
                JOptionPane.showMessageDialog(null, "La cantidad de notas debe ser un número positivo.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Array para almacenar las notas
            double[] notas = new double[cantidadNotas];
            
            // Solicitar las notas
            for (int i = 0; i < cantidadNotas; i++) {
                String notaStr = JOptionPane.showInputDialog(null, "Ingrese la nota " + (i + 1) + ":");
                double nota = Double.parseDouble(notaStr);
                
                // Verificar que las notas sean válidas
                if (nota < 0) {
                    JOptionPane.showMessageDialog(null, "Las notas deben ser valores positivos.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                notas[i] = nota;
            }
            
            // Calcular el total de las notas
            double sumaNotas = 0;
            for (double nota : notas) {
                sumaNotas += nota;
            }
            
            // Verificar que la suma de las notas no sea cero para evitar división por cero
            if (sumaNotas == 0) {
                JOptionPane.showMessageDialog(null, "La suma de las notas no puede ser cero.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Calcular el porcentaje de cada nota
            double[] porcentajes = new double[cantidadNotas];
            for (int i = 0; i < cantidadNotas; i++) {
                porcentajes[i] = (notas[i] / sumaNotas) * 100;
            }
            
            // Crear un mensaje con los resultados
            StringBuilder mensaje = new StringBuilder("Porcentaje de cada nota:\n");
            for (int i = 0; i < cantidadNotas; i++) {
                mensaje.append("Nota ").append(i + 1).append(": ").append(String.format("%.2f", porcentajes[i])).append("%\n");
            }
            
            // Mostrar el resultado
            JOptionPane.showMessageDialog(null, mensaje.toString(), "Resultados", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada inválida. Asegúrese de ingresar números válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
