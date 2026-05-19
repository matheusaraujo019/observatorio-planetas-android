package sp.senai.br.planetas;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class MainActivity extends AppCompatActivity {

    Spinner spSpinner;
    TextView tvDescricao;
    ImageView imgPlaneta;
    List<String> alPlanetas;

    // Array com: Nome | Descrição completa | Nome do arquivo de imagem (sem extensão)
    String[][] asPlanetas = {
            {"Mercúrio", "Distância: 57,9 milhões km\nTamanho: 4.879 km de diâmetro\nTemperatura: -180°C a 430°C\nLuas: Nenhuma\nAnéis: Não possui\nFormação: Rochoso\nCuriosidade: É o planeta com a maior variação de temperatura do sistema solar.", "mercurio"},
            {"Vênus", "Distância: 108,2 milhões km\nTamanho: 12.104 km de diâmetro\nTemperatura: Média de 465°C\nLuas: Nenhuma\nAnéis: Não possui\nFormação: Rochoso\nCuriosidade: Gira no sentido contrário da maioria dos planetas.", "venus"},
            {"Terra", "Distância: 149,6 milhões km\nTamanho: 12.742 km de diâmetro\nTemperatura: Média de 15°C\nLuas: 1 (a Lua)\nAnéis: Não possui\nFormação: Rochoso\nCuriosidade: É o único planeta conhecido que abriga vida.", "terra"},
            {"Marte", "Distância: 227,9 milhões km\nTamanho: 6.779 km de diâmetro\nTemperatura: Média de -63°C\nLuas: 2 (Fobos e Deimos)\nAnéis: Não possui\nFormação: Rochoso\nCuriosidade: Possui o maior vulcão do sistema solar, o Monte Olimpo.", "marte"},
            {"Júpiter", "Distância: 778,5 milhões km\nTamanho: 139.820 km de diâmetro\nTemperatura: Média de -108°C\nLuas: 79 conhecidas\nAnéis: Sim, finos\nFormação: Gasoso\nCuriosidade: Sua Grande Mancha Vermelha é uma tempestade maior que a Terra.", "jupiter"},
            {"Saturno", "Distância: 1,43 bilhões km\nTamanho: 116.460 km de diâmetro\nTemperatura: Média de -139°C\nLuas: 82 conhecidas\nAnéis: Sim, grandes e visíveis\nFormação: Gasoso\nCuriosidade: Seus anéis são formados por gelo e rochas.", "saturno"},
            {"Urano", "Distância: 2,87 bilhões km\nTamanho: 50.724 km de diâmetro\nTemperatura: Média de -197°C\nLuas: 27 conhecidas\nAnéis: Sim, finos e escuros\nFormação: Gelo e gás\nCuriosidade: Roda praticamente de lado em relação à sua órbita.", "urano"},
            {"Netuno", "Distância: 4,5 bilhões km\nTamanho: 49.244 km de diâmetro\nTemperatura: Média de -201°C\nLuas: 14 conhecidas\nAnéis: Sim, tênues\nFormação: Gelo e gás\nCuriosidade: Possui os ventos mais rápidos do sistema solar.", "netuno"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Referências aos componentes do layout
        spSpinner = findViewById(R.id.spSpinner);
        tvDescricao = findViewById(R.id.tvDescricao);
        imgPlaneta = findViewById(R.id.imgPlaneta);

        // Populando a lista de nomes de planetas
        alPlanetas = new ArrayList<>();
        for (int i = 0; i < asPlanetas.length; i++) {
            alPlanetas.add(asPlanetas[i][0]);
        }

        // Adaptador para o Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, alPlanetas);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spSpinner.setAdapter(adapter);

        // Evento de seleção no Spinner
        spSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tvDescricao.setText(asPlanetas[position][1]);

                // Carregando imagem correspondente
                int imgId = getResources().getIdentifier(asPlanetas[position][2], "drawable", getPackageName());
                imgPlaneta.setImageResource(imgId);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Não faz nada se nenhum item for selecionado
            }
        });
    }
}