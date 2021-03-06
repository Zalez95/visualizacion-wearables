package visualizacionwearables.vista;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.JRadioButtonMenuItem;

/**
 * Clase VentanaGraficoVista, representa la ventana interna encargada de
 * contener los graficos.
 * 
 * @author  Daniel González Alonso
 * @since   27/07/2016
 * @version 1.0
 */
public class VentanaGraficoVista extends javax.swing.JInternalFrame {
    
    /** El controlador de la ventana actual */
    private final VentanaGraficoControlador miControlador;
    
    /** El indice del rectangulo del graficoSuperior */
    private final int mRectanguloMapa;
    
    /** Constructor de VentanaGraficoVista, crea una ventana para mostrar un
     * grafico
     * 
     * @param controlador el controlador que se encargara de validar los datos
     *          de la vista y actualizarla con los datos del modelo. */
    public VentanaGraficoVista(VentanaGraficoControlador controlador) {
        miControlador = controlador;
        initComponents();
        mRectanguloMapa = graficoSuperior.addRectangulo(new Color(0, 0, 0, 50));
    }
    
    /** @return el grafico superior de la ventana */
    public GraficoPanel getGraficoSuperior() {
        return graficoSuperior;
    }
    
    /** @return el grafico inferior de la ventana */
    public GraficoPanelInteraccion getGraficoInferior() {
        return graficoInferior;
    }
    
    /** @return el indice de la opcion seleccionada en el comboBox, 
     *      -1 en caso de error */
    public int getSeleccionComboBox() {
        Enumeration<AbstractButton> botones = seleccionDatoGroup.getElements();
        
        for (int ret = 0; botones.hasMoreElements(); ret++) {
            if (botones.nextElement().isSelected()) {
                return ret;
            }
        }
        return -1;
    }
    
    /** Añade una opcion al Combobox de la ventana de grafico
     *
     * @param opcion la opcion que queremos añadir a la ventana */
    public void addOpcionSeleccionDato(String opcion) {
        JRadioButtonMenuItem nuevoBotonDato = new JRadioButtonMenuItem(opcion);
        nuevoBotonDato.setSelected(false);
        nuevoBotonDato.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miControlador.onDatoSeleccionado();
            }
        });
        
        seleccionDatoGroup.add(nuevoBotonDato);
        seleccionDatoMenu.add(nuevoBotonDato);
    }
        
    /** @return la posicion actual de la barra de scroll en el rango
     * [0.0, 1.0] */
    public int getValueScrollbar() {
        return graficoInferiorScrollbar.getValue();
    }
    
    /** @return el maximo valor posible en la barra de Scroll */
    public int getMaxValueScrollBar() {
        return graficoInferiorScrollbar.getMaximum();
    }
    
    /** Cambia el tamaño de la barra de scroll de forma proporcional a su
     * tamaño actual
     * 
     * @param nuevoTam el tamaño que ha de ocupar la barra de scroll */
    public void escalaScrollbar(int nuevoTam) {
        graficoInferiorScrollbar.setVisibleAmount(nuevoTam);  
    }
    
    /** Cambia la posicion de la barra de scroll de forma proporcional a su 
     * tamaño actual
     * 
     * @param nuevoDesp la posicion donde se ha de colocar la 
     *      barra de scroll */
    public void desplazaScrollbar(int nuevoDesp) {
        graficoInferiorScrollbar.setValue(nuevoDesp);
    }
    
    /** @return el rectangulo que representa la zona actual visualizada del
     * grafico en el grafico inferior */
    public Rectangulo getRectanguloMapa() {
        return graficoSuperior.getRectangulo(mRectanguloMapa);
    }
    
    /** @return true si el checkbox de la visualizacion de los puntos esta
     *      seleccionado, false en caso contrario */
    public boolean isPuntosCheckboxSeleccionado() {
        return puntosCheckbox.isSelected();
    }
    
    /** @return true si el checkbox de la visualizacion del grafico superior
     *      esta seleccionado, false en caso contrario */
    public boolean isPanelSuperiorCheckboxSeleccionado() {
        return puntosCheckbox.isSelected();
    }
    
    /** Muestra/oculta el panel superior de la ventana
     * 
     * @param ocultar true si queremos ocultar el panel superior, flase en
     *      caso contrario */
    public void ocultarPanelSuperior(boolean ocultar) {
        panelSuperior.setVisible(!ocultar);
        panelSuperiorCheckbox.setSelected(ocultar);
    }
    

    @Override
    public void paint(Graphics g) {
        miControlador.onPaint();
        super.paint(g);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contextMenuGraficoInferior = new javax.swing.JPopupMenu();
        puntosCheckbox = new javax.swing.JCheckBoxMenuItem();
        ampliarButton = new javax.swing.JMenuItem();
        reducirButton = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        seleccionDatoMenu = new javax.swing.JMenu();
        seleccionDatoGroup = new javax.swing.ButtonGroup();
        contextMenuVentanta = new javax.swing.JPopupMenu();
        panelSuperiorCheckbox = new javax.swing.JCheckBoxMenuItem();
        panelSuperior = new javax.swing.JPanel();
        graficoSuperior = new visualizacionwearables.vista.GraficoPanel(false, true, false);
        panelInferior = new javax.swing.JPanel();
        graficoInferior = new visualizacionwearables.vista.GraficoPanelInteraccion(false, true, true);
        graficoInferiorScrollbar = new javax.swing.JScrollBar();

        puntosCheckbox.setText("Mostrar Puntos");
        puntosCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                puntosCheckboxActionPerformed(evt);
            }
        });
        contextMenuGraficoInferior.add(puntosCheckbox);

        ampliarButton.setText("Ampliar");
        ampliarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ampliarButtonActionPerformed(evt);
            }
        });
        contextMenuGraficoInferior.add(ampliarButton);

        reducirButton.setText("Reducir");
        reducirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reducirButtonActionPerformed(evt);
            }
        });
        contextMenuGraficoInferior.add(reducirButton);
        contextMenuGraficoInferior.add(jSeparator1);

        seleccionDatoMenu.setText("Seleccionar Dato");
        contextMenuGraficoInferior.add(seleccionDatoMenu);

        panelSuperiorCheckbox.setText("Ocultar Grafico Superior");
        panelSuperiorCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                panelSuperiorCheckboxActionPerformed(evt);
            }
        });
        contextMenuVentanta.add(panelSuperiorCheckbox);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setComponentPopupMenu(contextMenuVentanta);
        setMinimumSize(new java.awt.Dimension(80, 60));
        setPreferredSize(new java.awt.Dimension(640, 480));
        setVisible(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        panelSuperior.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        graficoSuperior.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout graficoSuperiorLayout = new javax.swing.GroupLayout(graficoSuperior);
        graficoSuperior.setLayout(graficoSuperiorLayout);
        graficoSuperiorLayout.setHorizontalGroup(
            graficoSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
        );
        graficoSuperiorLayout.setVerticalGroup(
            graficoSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 79, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelSuperiorLayout = new javax.swing.GroupLayout(panelSuperior);
        panelSuperior.setLayout(panelSuperiorLayout);
        panelSuperiorLayout.setHorizontalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(graficoSuperior, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelSuperiorLayout.setVerticalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 79, Short.MAX_VALUE)
            .addGroup(panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(graficoSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelInferior.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        graficoInferior.setBackground(new java.awt.Color(255, 255, 255));
        graficoInferior.setComponentPopupMenu(contextMenuGraficoInferior);

        javax.swing.GroupLayout graficoInferiorLayout = new javax.swing.GroupLayout(graficoInferior);
        graficoInferior.setLayout(graficoInferiorLayout);
        graficoInferiorLayout.setHorizontalGroup(
            graficoInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        graficoInferiorLayout.setVerticalGroup(
            graficoInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 331, Short.MAX_VALUE)
        );

        graficoInferiorScrollbar.setOrientation(javax.swing.JScrollBar.HORIZONTAL);
        graficoInferiorScrollbar.addAdjustmentListener(new java.awt.event.AdjustmentListener() {
            public void adjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
                graficoInferiorScrollbarAdjustmentValueChanged(evt);
            }
        });

        javax.swing.GroupLayout panelInferiorLayout = new javax.swing.GroupLayout(panelInferior);
        panelInferior.setLayout(panelInferiorLayout);
        panelInferiorLayout.setHorizontalGroup(
            panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(graficoInferiorScrollbar, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
            .addComponent(graficoInferior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelInferiorLayout.setVerticalGroup(
            panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInferiorLayout.createSequentialGroup()
                .addComponent(graficoInferior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(graficoInferiorScrollbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        graficoInferiorScrollbar.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelInferior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelInferior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void graficoInferiorScrollbarAdjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {//GEN-FIRST:event_graficoInferiorScrollbarAdjustmentValueChanged
        if (evt.getValueIsAdjusting()) { miControlador.onScroll(); }
    }//GEN-LAST:event_graficoInferiorScrollbarAdjustmentValueChanged

    private void ampliarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ampliarButtonActionPerformed
        miControlador.onAmpliar();
    }//GEN-LAST:event_ampliarButtonActionPerformed

    private void reducirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reducirButtonActionPerformed
        miControlador.onReducir();
    }//GEN-LAST:event_reducirButtonActionPerformed

    private void puntosCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_puntosCheckboxActionPerformed
        miControlador.onPuntosCheckbox();
    }//GEN-LAST:event_puntosCheckboxActionPerformed

    private void panelSuperiorCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_panelSuperiorCheckboxActionPerformed
        miControlador.onPanelSuperiorCheckbox();
    }//GEN-LAST:event_panelSuperiorCheckboxActionPerformed

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        miControlador.onResize();
    }//GEN-LAST:event_formComponentResized

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ampliarButton;
    private javax.swing.JPopupMenu contextMenuGraficoInferior;
    private javax.swing.JPopupMenu contextMenuVentanta;
    private visualizacionwearables.vista.GraficoPanelInteraccion graficoInferior;
    private javax.swing.JScrollBar graficoInferiorScrollbar;
    private visualizacionwearables.vista.GraficoPanel graficoSuperior;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPanel panelInferior;
    private javax.swing.JPanel panelSuperior;
    private javax.swing.JCheckBoxMenuItem panelSuperiorCheckbox;
    private javax.swing.JCheckBoxMenuItem puntosCheckbox;
    private javax.swing.JMenuItem reducirButton;
    private javax.swing.ButtonGroup seleccionDatoGroup;
    private javax.swing.JMenu seleccionDatoMenu;
    // End of variables declaration//GEN-END:variables
}
