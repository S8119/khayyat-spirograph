package khayyat.spirograph;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class SpirographControllerTest
{

    @Test
    void updateView()
    {
        //given
        SpirographView view = mock();
        SpirographController controller = new SpirographController(view);

        //when
        controller.updateView(200.0, 75.0, 55.0, 8000, .007);

        //then
        verify(view).setModel(new SpirographModel(
                200.0, 75.0, 55.0, 8000, .007));
    }
}