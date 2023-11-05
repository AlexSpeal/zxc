package edu.project2;

import java.util.List;

public interface Render {
    StringBuilder print();

    StringBuilder print(List<Cell> way);
}
