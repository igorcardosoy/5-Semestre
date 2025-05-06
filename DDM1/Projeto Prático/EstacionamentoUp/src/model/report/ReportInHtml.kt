package model.report

import model.veiculo.Veiculo

class ReportInHtml : Report {
    override fun getAll(carros: List<Veiculo>, motos: List<Veiculo>): String{
        val htmlReport: StringBuilder = StringBuilder()

        htmlReport.append("<body>\n")

        abrirMascaraDeCarros(htmlReport)

        for (veiculo in carros)
            adicionarVeiculo(htmlReport, veiculo)

        fecharMascaraDeCarros(htmlReport)

        abrirMascaraDeMotos(htmlReport)

        for (veiculo in motos)
            adicionarVeiculo(htmlReport, veiculo)

        fecharMascaraDeMotos(htmlReport)

        htmlReport.append("</body>")

        return htmlReport.toString()
    }

    private fun adicionarVeiculo(htmlReport: StringBuilder, veiculo: Veiculo) {
        htmlReport.append("" +
                "   <tr>\n" +
                "     <td> ${veiculo.placa}</td>\n" +
                "     <td> ${veiculo.getSegundos()}</td>\n" +
                "   </tr>"
        )
    }

    private fun abrirMascaraDeCarros(htmlReport: StringBuilder){
        htmlReport.append("" +
                "<h2>Carros</h2>\n" +
                "<table border=\"1\" cellspacing=\"0\" cellpadding=\"5\">\n" +
                "  <thead>\n" +
                "    <tr>\n" +
                "      <th>Placa</th>\n" +
                "      <th>Tempo (segundos)</th>\n" +
                "    </tr>\n" +
                "  </thead>\n" +
                "  <tbody>"
        )
    }

    private fun fecharMascaraDeCarros(htmlReport: StringBuilder){
        htmlReport.append("" +
                "  </tbody>\n" +
                "</table>\n"
        )
    }

    private fun abrirMascaraDeMotos(htmlReport: StringBuilder){
        htmlReport.append("" +
                "<h2>Motos</h2>\n" +
                "<table border=\"1\" cellspacing=\"0\" cellpadding=\"5\">\n" +
                "  <thead>\n" +
                "    <tr>\n" +
                "      <th>Placa</th>\n" +
                "      <th>Tempo (segundos)</th>\n" +
                "    </tr>\n" +
                "  </thead>\n" +
                "  <tbody>"
        )
    }

    private fun fecharMascaraDeMotos(htmlReport: StringBuilder){
        htmlReport.append("" +
                "  </tbody>\n" +
                "</table>\n"
        )
    }
}